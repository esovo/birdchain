<template>
  <div>
    <MarkerTypeButton></MarkerTypeButton>
    
    <KakaoMap></KakaoMap>
    <MarkerRegist></MarkerRegist>
  </div>
</template>

<script setup>
import KakaoMap from "@/components/map/KakaoMap.vue"
import MarkerTypeButton from "@/components/map/MarkerTypeButton.vue";
import MarkerRegist from "@/components/map/MarkerRegist.vue";
</script>

<style lang="scss" scoped>

</style>