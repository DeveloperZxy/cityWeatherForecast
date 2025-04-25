<template>
  <el-select
    v-model="selectedIds"
    placeholder="Select"
    size="large"
    style="width: 240px"
    multiple
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
import { getListApi } from "@/api/system/roles/rolesInfoApi";
import { defineProps, defineEmits, computed, ref, onMounted, watch } from "vue";

// 定义 props
const props = defineProps<{
  modelValue: Array<number | string>;
}>();

// 定义 emit
const emit = defineEmits(["update:modelValue"]);

const selectedIds = ref<Array<number | string>>(props.modelValue);

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

watch(selectedIds, newVal => {
  emit("update:modelValue", newVal);
});

const handleSelectionChange = (ids: Array<number | string>) => {
  const selectedLabels = ids.map(id => {
    const option = options.value.find(option => option.id === id);
    return option ? option.label : "";
  });
  console.log(`Selected IDs: ${ids}, Labels: ${selectedLabels}`);
};
</script>
