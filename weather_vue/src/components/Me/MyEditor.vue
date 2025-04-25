<template>
  <div>
    <el-form-item label="内容">
      <el-input v-model="proxy" clearable filterable type="textarea" />
    </el-form-item>

    <button @click="insertText">insert text</button>
    <div style="border: 1px solid #ccc">
      <Toolbar
        style="border-bottom: 1px solid #ccc"
        :editor="editorRef"
        :defaultConfig="toolbarConfig"
        :mode="mode"
      />
      <Editor
        v-model="valueHtml"
        style="height: 500px; overflow-y: hidden"
        :defaultConfig="editorConfig"
        :mode="mode"
        @onCreated="handleCreated"
        @onChange="handleChange"
        @onDestroyed="handleDestroyed"
        @onFocus="handleFocus"
        @onBlur="handleBlur"
        @customAlert="customAlert"
        @customPaste="customPaste"
      />
    </div>
  </div>
</template>

<script lang="ts" setup>
import { computed, defineEmits, defineProps, onMounted, ref } from "vue";
import { getListApi } from "@/api/crm/user/userInfoApi";
import { getToken, formatToken } from "@/utils/auth";
import { onBeforeUnmount, shallowRef } from "vue";
import { Editor, Toolbar } from "@wangeditor/editor-for-vue";
import "@wangeditor/editor/dist/css/style.css"; // 引入 css

// 定义 props
const props = defineProps<{
  modelValue: string;
  valueType: string;
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

// 计算属性
const proxy = computed({
  get() {
    console.debug("计算属性Get", props.modelValue);
    return props.modelValue;
  },
  set(v) {
    console.debug("计算属性Set", v);

    emit("update:modelValue", v);
  }
});

// 选项数据
const options = ref([]);

// 获取选项数据
const getOptions = async () => {
  let res = await getListApi({});
  options.value = res.data;
  console.debug("options", options.value);
};

// 编辑器相关
const editorRef = shallowRef();
const valueHtml = ref("<p>hello</p>");
const toolbarConfig = {};
const editorConfig = {
  placeholder: "请输入内容...",
  MENU_CONF: {
    uploadImage: {
      server: "http://127.0.0.1:8080/admin/file/upload/img",
      fieldName: "file",
      headers: {
        authorization: formatToken(getToken().accessToken)
      },
      customInsert: (response, insertImg) => {
        insertImg(response.data);
        console.log("response.data", response.data);
      }
    },
    uploadVideo: {
      server: "http://127.0.0.1:8080/admin/file/upload/img",
      fieldName: "file",
      headers: {
        authorization: formatToken(getToken().accessToken)
      },
      customInsert: (response, insertVideo) => {
        insertVideo(response.data);
        console.log("response.data", response.data);
      }
    }
  }
};

// 生命周期钩子
onMounted(() => {
  getOptions();
  setTimeout(() => {
    valueHtml.value = "<p>模拟 Ajax 异步设置内容</p>";
  }, 1500);
});

onBeforeUnmount(() => {
  const editor = editorRef.value;
  if (editor) editor.destroy();
});

// 事件处理函数
const handleCreated = editor => {
  editorRef.value = editor;
  console.log("created", editor);
};

const handleChange = editor => {
  console.log("change:", editor.children);
  // 1
  // proxy.value = valueHtml.value;
  // console.debug("valueHtml", valueHtml.value);
  // 2.获取html   如： <p>hello<p>
  proxy.value = editor.getHtml();
  console.debug("editor", editor);
  //3.获取纯文本
  // proxy.value = editor.getText();
  // console.debug("editor", editor);
};

const handleDestroyed = editor => {
  console.log("destroyed", editor);
};

const handleFocus = editor => {
  console.log("focus", editor);
};

const handleBlur = editor => {
  console.log("blur", editor);
};

const customAlert = (info, type) => {
  alert(`【自定义提示】${type} - ${info}`);
};

const insertText = () => {
  const editor = editorRef.value;
  if (editor) editor.insertText("hello world");
};

const customPaste = (editor, event, callback) => {
  console.log("ClipboardEvent 粘贴事件对象", event);

  // 获取剪贴板中的文本内容
  const text = (event.clipboardData || window.clipboardData).getData("text");

  // 将剪贴板中的文本插入到编辑器中
  editor.insertText(text);

  // 阻止默认的粘贴行为
  event.preventDefault();

  // 调用回调函数，表示已经处理了粘贴事件
  callback(true);
};
</script>

<style scoped>
.min-w-28 {
  min-width: 280px;
}
</style>
