<template>
  <div>
    <MarkerTypeButton></MarkerTypeButton>
    <KakaoMap></KakaoMap>
    <div class="flex-box">
      <MakerDetail></MakerDetail>
      <CommentCard></CommentCard>
    </div>
  </div>
</template>

<script setup>
import KakaoMap from "@/components/map/KakaoMap.vue";
import MarkerTypeButton from "@/components/map/MarkerTypeButton.vue";
import MakerDetail from "@/components/map/MarkerDetail.vue";
import CommentCard from "@/components/map/CommentCard.vue";
</script>

<style scoped>
.flex-box {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  background-color: #f7fbf3;
  padding: 50px 0;
}
</style>
