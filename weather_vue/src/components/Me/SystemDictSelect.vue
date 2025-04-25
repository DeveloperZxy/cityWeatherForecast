<template>
  <el-select
    v-model="proxy"
    clearable
    filterable
    class="min-w-28"
    @change="onChange"
  >
    <el-option
      v-for="(item, index) in options"
      :key="index"
      :label="item.name"
      :value="item.name"
    />
  </el-select>
</template>

<script lang="ts" setup>
// 定义 props
import { computed, defineEmits, defineProps, onMounted, ref } from "vue";
import * as dictInfoApi from "@/api/system/dict/dictInfoApi";

const props = defineProps<{
  modelValue: { type: [String]; required: true; default: undefined };
  dictCode: { type: String; required: true; default: undefined };
  valueType: { type: [String]; default: "String" };
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

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

const onChange = (val: any) => {
  console.debug("onChange", val);
  emit("update:modelValue", val);
};

const options = ref([]);
//
const getOptions = async () => {
  let res = await dictInfoApi.getlistByCodeApi(props.dictCode);
  options.value = res.data;
  console.debug("options", options.value);
};
onMounted(() => {
  getOptions();
});
</script>

<style scoped></style>
