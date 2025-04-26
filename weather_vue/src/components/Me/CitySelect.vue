<template>
  <el-select
    v-model="selectedId"
    placeholder="Select"
    size="large"
    style="width: 240px"
    @change="handleSelectionChange"
  >
    <el-option
      v-for="item in options"
      :key="item.id"
      :label="item.label"
      :value="item.id"
    />
  </el-select>
</template>

<script lang="ts" setup>
import { getListApi } from "@/api/weather/cityInfoApi";
import { defineProps, defineEmits, computed, ref, onMounted, watch } from "vue";

// 定义 props
const props = defineProps<{
  modelValue: string | number;
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

const selectedId = ref<number | string>(props.modelValue);

const options = ref([]);

const getOptions = async () => {
  let res = await getListApi({});
  options.value = res.data.map((item: any) => ({
    id: item.id,
    label: item.name,
    value: item.name
  }));
};

onMounted(() => {
  getOptions();
});

watch(selectedId, newVal => {
  emit("update:modelValue", newVal);
});

const handleSelectionChange = (id: number | string) => {
  const selectedOption = options.value.find(option => option.id === id);
  if (selectedOption) {
    console.log(`Selected: ${selectedOption.label} (ID: ${selectedOption.id})`);
  }
};
</script>
