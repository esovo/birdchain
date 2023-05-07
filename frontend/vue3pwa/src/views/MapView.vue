<template>
  <div>
    <MarkerTypeButton></MarkerTypeButton>
    <KakaoMap></KakaoMap>
    <MakerDetail></MakerDetail>
  </div>
</template>

<script setup>
import KakaoMap from "@/components/map/KakaoMap.vue";
import MarkerTypeButton from "@/components/map/MarkerTypeButton.vue";
import MakerDetail from "@/components/map/MarkerDetail.vue";
</script>

<style lang="scss" scoped></style>
