<template>
  <v-card width="400" height="600">
    <div v-for="comment in commentList" :key="comment.id" style="overflow: auto;">
      <CommentListItem
        :comment_id="comment.id"
        :nickname="comment.nickname"
        :content="comment.content"
        :createdAt="comment.createdAt"
      ></CommentListItem>
    </div>
    <div>
      <CommentRegist :marker_id="marker_id"></CommentRegist>
    </div>
  </v-card>
</template>
<script setup>
import CommentListItem from "@/components/map/CommentListItem.vue";
import CommentRegist from "@/components/map/CommentRegist.vue";
import { ref, defineProps, onMounted } from "vue";
import {getComments} from "@/api/comments";

const marker_id = ref(0);
marker_id.value = props.marker_id;

const props = defineProps({
  marker_id: {
    type: Number,
  },
});

const commentList = ref([]);
onMounted(() => {
  getCommentList();
});


const getCommentList = () => {
  getComments(marker_id.value).then(({data}) => {
    if(data.status === 'OK') {
      commentList.value = data.value;
    }
  })
}

</script>
<style scoped></style>
