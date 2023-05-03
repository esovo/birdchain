<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';

const { kakao } = window;

// 지도 생성하기
var map = null;
const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(36.354946759143, 	127.29980994578),
    level: 5,
  };
  
  //지도 객체를 등록합니다.
  map = new kakao.maps.Map(container, options);
};

// 마커 표시하기
const markerPositions = ref([ 
  [36.3559, 127.303],
  [36.3576, 127.3044],
  [36.3581, 127.308],
]);
const markers = ref([]);
const displayMarker = () => {
  // 기존에 있던 마커들 지우기
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
  // 마커의 위도&경도 객체 생성
  const positions = markerPositions.value.map(
    (position) => new kakao.maps.LatLng(...position)
  );
  // 전달받은 위도&경도로 마커 생성하고 지도에 표시하기 
  if (positions.length > 0) {
    markers.value = positions.map(
      (position) =>
        new kakao.maps.Marker({
          map,
          position,
        })
    );
  }
}

onMounted(() => {
  initMap();
  displayMarker();
});
</script>

<style scoped>
#map {
  margin: 0 auto;
  width: 85vw;
  height: 50vw;
}

@media (max-width: 600px) {
  #map {
    justify-content: center;
    width: 100vw;
    height: 90vw;
  }
}
</style>