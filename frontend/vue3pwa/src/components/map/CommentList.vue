<template>
  <v-card width="400" height="600" style="overflow: auto">
    <div v-for="comment in commentList" :key="comment.id">
      <CommentListItem
        :comment_id="comment.id"
        :nickname="comment.nickname"
        :content="comment.content"
        :createdAt="comment.createdAt"></CommentListItem>
    </div>
    <CommentRegist :marker_id="props.marker_id"></CommentRegist>
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
</script>
<style scoped></style>
