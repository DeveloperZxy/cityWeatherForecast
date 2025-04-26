<template>
  <div>
data:{{data}}
  </div>
</template>

<script lang="ts" setup>
import * as cityInfo from "@/api/weather/cityInfoApi"

import {ref} from "vue";
const data = ref([]);
const handleCurrentChange = async () => {
  let res = await cityInfo.getHotCitiesApi({});
  console.log(res.data);
  data.value = res.data;
};

handleCurrentChange();
</script>
