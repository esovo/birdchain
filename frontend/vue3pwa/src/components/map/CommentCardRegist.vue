<template>
  <div class="form-container">
    <form @submit.prevent>
      <div class="form-group">
        <label>아 이 디</label>
        <input type="text" v-model="form.nickname" />
      </div>
      <div class="form-group">
        <label>비밀번호</label>
        <input type="password" v-model="form.password" />
      </div>
      <div class="form-group">
        <label for="content">내 용</label>
        <textarea id="content" v-model="form.content"></textarea>
      </div>
    </form>
    <button type="submit">등록</button>
  </div>
</template>
<script setup>
import { ref } from "vue";
// const comments = ref([]);
const form = ref({
  nickname: null,
  password: null,
  content: null,
});
</script>
<style scoped>
.form-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.form-group {
  display: flex;
  margin-bottom: 10px;
}

label {
  margin-bottom: 5px;
  padding-right: 5px;
}

input[type="text"],
input[type="password"],
textarea {
  padding: 10px;
  font-size: 14px;
  border: 1px solid gray;
  border-radius: 4px;
  outline: none;
}

button[type="submit"] {
  padding: 10px 20px;
  background-color: #4caf50;
  color: white;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #3e8e41;
}
</style>
