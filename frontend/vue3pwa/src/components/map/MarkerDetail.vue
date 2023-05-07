<template>
  <v-card max-width="400" height="600">
    <div class="flex-container">
      <v-card-title class="mr-14"> 닉네임 </v-card-title>
      <div>
        <v-btn icon="fa:fas fa-edit"> </v-btn>
        <v-btn :icon="`mdiSvg:${mdiDelete}`"> </v-btn>
      </div>
    </div>
    <v-img
      src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
      height="300px"
      cover
      class="my-4"></v-img>

    <v-card-text class="d-flex align-start flex-column ml-3">
      <div>
        <span> <strong>위치</strong></span>
        <span>여기여기여기</span>
      </div>
      <div>
        <span><strong>내용</strong></span>
        <span>여기여기여기</span>
      </div>
    </v-card-text>
  </v-card>
</template>

<script setup>
// import { mdiDelete } from "@mdi/js";
// import { getMarkerDetail } from "@/api/markers";
</script>

<style scoped>
.flex-container {
  display: flex;
  justify-content: flex-end;
  margin: 10px 0;
}
</style>
