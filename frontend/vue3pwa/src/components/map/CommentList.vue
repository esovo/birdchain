<template>
  <v-card class="my-card" @wheel.prevent="onWheel">
    <div class="scroll-container" v-scroll-y>
      <div class="comments" style="height: 400px">
        <CommentListItem
          v-for="comment in commentList"
          :key="comment.id"
          :comment_id="comment.id"
          :nickname="comment.nickname"
          :content="comment.content"
          :createdAt="comment.createdAt" />
      </div>
    </div>
    <div class="comment-regist-wrapper">
      <CommentRegist :marker_id="props.marker_id" @reloadComment="reloadComment"/>
    </div>
  </v-card>
</template>
<script setup>
import CommentListItem from "@/components/map/CommentListItem.vue";
import CommentRegist from "@/components/map/CommentRegist.vue";
import { ref, defineProps, watch } from "vue";
import { getComments } from "@/api/comments";

const props = defineProps({
  marker_id: {
    type: Number,
  },
});

const commentList = ref([]);

const getCommentList = () => {
  getComments(props.marker_id).then(({ data }) => {
    if (data.status === "OK") {
      commentList.value = data.value;
    } else {
      console.log(data.status);
    }
  });
};

getCommentList();
watch(
  () => props.marker_id,
  (newValue, oldValue) => {
    if (newValue !== oldValue) {
      getCommentList();
    }
  }
);

const reloadComment = () => {
  getCommentList();
}


const onWheel = (event) => {
  event.preventDefault();
  const container = event.currentTarget.querySelector(".comments");
  container.scrollTop += event.deltaY;
};
</script>
<style scoped>
.my-card {
  width: 400px;
  height: 600px;
  position: relative;
}
.scroll-container {
  height: 100%;
  overflow-y: auto;
}
.comments {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  /* bottom: 40px; CommentRegist 높이만큼 여유 높이 */
  overflow-y: auto;
  border-bottom: 0.1px solid rgb(190, 190, 190);
}
.comment-regist-wrapper {
  position: absolute;
  bottom: 0;
  left: 15px;
  right: 0;
  height: 200px; /* CommentRegist 높이 */
}
</style>
