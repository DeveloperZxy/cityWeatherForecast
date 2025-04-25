<template>
  <div>
    roleId ：{{ formData.roleId }} adminId :{{ formData.adminId }}
    <RoleSelect v-model="formData.roleId" />
    <AdminSelect v-model="formData.adminId" />
  </div>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { ElTree } from "element-plus";
import type Node from "element-plus/es/components/tree/src/model/node";
import RoleSelect from "@/components/Me/RoleSelect.vue";
import AdminSelect from "@/components/Me/AdminSelect.vue";

let formData = ref({
  roleId: [],
  adminId: ""
});
</script>
