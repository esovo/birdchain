<template>
  <v-card class="my-card" @wheel.prevent="onWheel">
    <div class="comment-list">
      <CommentListItem
        @reloadComment="reloadComment"
        :marker_id="props.marker_id"
        v-for="comment in commentList"
        :key="comment.id"
        :comment_id="comment.id"
        :nickname="comment.nickname"
        :content="comment.content"
        :createdAt="comment.createdAt" />
    </div>
    <div class="comment-regist">
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
    commentList.value = data.value;
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
  const container = event.currentTarget.querySelector(".comment-list");
  container.scrollTop += event.deltaY;
};
</script>
<style scoped>
.my-card {
  width: 400px;
  height: 600px;
  position: relative;
}

.comment-list {
  height: 400px;
  overflow-y: auto;
  border-bottom: 0.1px solid rgb(190, 190, 190);
}

.comment-regist {
  position: absolute;
  bottom: 15px;
  left: 10px;
}
</style>
