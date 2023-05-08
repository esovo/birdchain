<template>
  <div class="flex-container">
    <div>
      <v-card-item class="d-flex">
        <v-card-title> 닉네임</v-card-title>
        <v-card-subtitle>등록날짜 </v-card-subtitle>
      </v-card-item>
      <v-card-text style="max-width: 300px;"> 글내용글내용글내용글내용글내용글내용글내용글내용글내용글내용글내용글내용</v-card-text>
    </div>
    <div class="icons">
      <v-btn icon="fa:fas fa-edit" size="40" class="mr-2"> </v-btn>
      <v-btn :icon="`mdiSvg:${mdiDelete}`" size="40"> </v-btn>
    </div>
  </div>
</template>
<script setup>
import {defineProps} from 'vue';
import { mdiDelete } from "@mdi/js";

defineProps({
  comment_id: {
    type: String,
  },
	nickname: {
		type: String,
	},
	content: {
		type: String,
	},
	createdAt: {
		type: [String, Date],
	},
});
</script>
<style scoped>
.flex-container {
  display: flex;
  justify-content: space-around;
}
.icons {
  margin-top: 1vw;
}
</style>
