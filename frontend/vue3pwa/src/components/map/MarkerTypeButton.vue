<template>
  <div class="mapbutton">
    <v-btn-toggle
      v-model="toggle_multiple"
      color="light-green lighten-2"
      multiple
      variant="outlined"
      divided
      @click="selectType">
      <v-btn value="버드스트라이크"> 버드<br />스트라이크 </v-btn>
      <v-btn value="새발견"> 새발견 </v-btn>
    </v-btn-toggle>
  </div>
</template>
<script setup>
import { ref, defineEmits } from "vue";

const emit = defineEmits(["searchByType"]);
const toggle_multiple = ref([]);

const selectType = () => {
  emit("searchByType", toggle_multiple.value);
};
</script>

<style scoped>
.mapbutton {
  margin-top: 30px;
  margin-bottom: 30px;
}

.v-btn-group--density-default.v-btn-group {
  position: relative;
  left: 30%;
}

@media (max-width: 600px) {
  .v-btn {
    width: 80px;
  }
  .v-btn-group--density-default.v-btn-group {
    position: relative;
    left: 23vw;
  }
}
</style>
