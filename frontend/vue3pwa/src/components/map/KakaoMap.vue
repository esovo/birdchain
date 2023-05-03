<template>
  <div>
    <div id="map"></div>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';

const { kakao } = window;

// 지도 생성하기
const map = ref(null);

const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(36.354946759143, 	127.29980994578),
    level: 5,
  };
  
  //지도 객체를 등록합니다.
  //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
  map.value = new kakao.maps.Map(container, options);
};

// 마커 표시하기
const markerPositions = ref([ 
  [36.3559, 127.303],
  [36.3576, 127.3044],
  [36.3581, 127.308],
]);
const markers = ref([]);

const displayMarker = () => {
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }

  const positions = markerPositions.value.map(
    (position) => new kakao.maps.LatLng(...position)
  );

  if (positions.length > 0) {
    markers.value = positions.map(
      (position) =>
        new kakao.maps.Marker({
          map,
          position,
        })
    );

    // const bounds = positions.reduce(
    //   (bounds, latlng) => bounds.extend(latlng),
    //     new kakao.maps.LatLngBounds()
    // );

    // map.value.setBounds(bounds);
  }
}

onMounted(() => {
  initMap();
  displayMarker();
});
// onMounted(() => {
//   if (window.kakao && window.kakao.maps) {
//     initMap();
//   } else {
//     const script = document.createElement("script");
//     /* global kakao */
//     script.onload = () => kakao.maps.load(initMap);
//     script.src =
//       `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}`;
//     document.head.appendChild(script);
//   }
//   displayMarker();
// });
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