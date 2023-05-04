<template>
  <div>
    <div v-if="showModal" class="modal" :style="{ top: modalTop + 'px', left: modalLeft + 'px' }">
      <div class="modal-content">
        <h3>New Post</h3>
        <form>
          <div>
            <label>닉네임</label>
            <input type="text" v-model="form.nickname">
          </div>
          <div>
            <label>비밀번호</label>
            <input type="password" v-model="form.password">
          </div>
          <div>
            <label>이미지</label>
            <input type="file" v-on="form.image">
          </div>
          <div>
            <label>유형</label>
            <select v-model="form.category">
              <option value="">유형을 선택하세요.</option>
              <option v-for="(category, index) in categories" :key="index" :value="category">
                {{ category }}
              </option>
            </select>
          </div>
          <div>
            <label>위치</label>
            <input type="text" v-model="form.location" readonly>
          </div>
          <div>
            <label>내용</label>
            <textarea v-model="form.content"></textarea>
          </div>
          <div>
            <button type="button" @click="showModal = false">취소</button>
            <button type="submit">등록</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const form = ref({
  nickname: null,
  password: null,
  image: {},
  category: null,
  location: '대전광역시 유성구 덕명동 124',
	content: null,
});

const showModal = ref(true);
const modalTop = ref(50);
const modalLeft = ref(50);

const categories = ['버드스트라이크', '새발견'];
</script>

<style lang="scss" scoped>
* {
  margin: 0;
  padding: 0;
  border: 1px solid black;
}
</style>