<template>
  <div>
    <div id="map" @click="showRegistModal"></div>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';
// import MakerRegist from '@/components/map/MarkerRegist.vue';

const { kakao } = window;

// <지도 생성하기>
var map = null;
var curMarker = null;
const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(36.354946759143, 	127.29980994578),
    level: 5,
  };
  
  //지도 객체를 등록합니다.
  map = new kakao.maps.Map(container, options);

  //마커 이미지의 이미지 주소입니다
  var imageSrc = "img/icons/pin.png";

  // 마커 이미지의 이미지 크기 입니다
  var imageSize = new kakao.maps.Size(50, 50);

  // 마커 이미지를 생성합니다
  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

  // 지도를 클릭한 위치에 표출할 마커입니다
  curMarker = new kakao.maps.Marker({ 
      // 지도 중심좌표에 마커를 생성합니다 
      position: map.getCenter(),
      image: markerImage,
  }); 

  // 지도에 마커를 표시합니다
  curMarker.setMap(map);
};

// <마커 표시하기>
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


// <마커 등록창 띄우기>
const showRegistModal = () => {
  // 지도에 클릭 이벤트를 등록합니다
  // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
  kakao.maps.event.addListener(map, 'click', function(mouseEvent) { 
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    curMarker.setPosition(latlng); 

    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';

    console.log(message);
  });
}
</script>

<style scoped>
#map {
  margin: 0 auto;
  width: 85vw;
  height: 40vw;
}

@media (max-width: 600px) {
  #map {
    justify-content: center;
    width: 100vw;
    height: 90vw;
  }
}
</style>