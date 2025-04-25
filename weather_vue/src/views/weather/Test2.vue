<template>
  <el-form :model="form" label-width="auto" style="max-width: 600px">
    <el-form-item label="城市名称">
      <el-input v-model="form.name" />
    </el-form-item>
    <el-form-item label="和风天气对应城市">
      <el-select v-model="form.region" placeholder="please select your zone">
        <el-option label="城市1" value="shanghai" />
        <el-option label="城市2" value="beijing" />
      </el-select>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onSubmit">Create</el-button>
      <el-button>Cancel</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive } from 'vue'

// do not use same name with ref
const form = reactive({
  name: '',
  region: '',
  date1: '',
  date2: '',
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})

const onSubmit = () => {
  console.log('submit!')
}
</script>
