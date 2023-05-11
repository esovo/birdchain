<template>
  <div class="flex-box">
    <div>
      <div id="map" @click.once="movePin"></div>
      <MarkerRegist
        :placeInfo="placeInfo"
        :map="map"
        @reloadMarker="reloadMarker"></MarkerRegist>
    </div>
    <MakerDetail
    :marker_id="marker_id"
    @reloadMarker="reloadMarker"
    @notValid="notValid"
    v-if="isValid"></MakerDetail>
    <CommentList v-if="isValid" :marker_id="marker_id" class="commentList"></CommentList>
  </div>
</template>

<script setup>
import MarkerRegist from "@/components/map/MarkerRegist.vue";
import MakerDetail from "@/components/map/MarkerDetail.vue";
import CommentList from "@/components/map/CommentList.vue";
import { ref, onMounted, reactive } from "vue";
import { getMarkersByType } from "@/api/markers";
const { kakao } = window;

// <지도 생성하기>
var map = null;
var curMarker = null;
const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(36.354946759143, 127.29980994578),
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
const markers = ref([]);
const markerData = ref([]);
const marker_id = ref(1);
const displayMarker = () => {
  // 기존에 있던 마커들 지우기
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }

  // axios 요청 보내서 DB 마커 가젹오기
  getMarkersByType("").then(({ data }) => {
    markerData.value = data.value;

    // 전달받은 위도&경도로 마커 생성하고 지도에 표시하기
    if (markerData.value.length > 0) {
      markerData.value.forEach((m) => {
        // 위도, 경도로 위치 정보를 생성
        var markerPosition = new kakao.maps.LatLng(m.lat, m.lng);
        const marker = new kakao.maps.Marker({
          map,
          position: markerPosition,
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, "click", function () {
          isValid.value = true;
          marker_id.value = m.id;
        });
        // 생성한 마커를 markers 배열에 추가하기
        markers.value.push(marker);
      });
    }
  });
};

onMounted(() => {
  initMap();
  displayMarker();
});

// <클릭한 위치 위도, 경도, 법정동 주소 가져오기>
const placeInfo = reactive([]);
const movePin = () => {
  // 지도에 클릭 이벤트를 등록합니다
  // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
  kakao.maps.event.addListener(map, "click", function (mouseEvent) {
    searchDetailAddrFromCoords(mouseEvent.latLng, function (result, status) {
      if (status === kakao.maps.services.Status.OK) {
        // 클릭한 위도, 경도 정보를 가져옵니다
        var latlng = mouseEvent.latLng;
        // 마커 위치를 클릭한 위치로 옮깁니다
        curMarker.setPosition(latlng);
        // 위도
        placeInfo[0] = latlng.getLat();
        // 경도
        placeInfo[1] = latlng.getLng();
        // 도로명 주소
        result[0].road_address
          ? (placeInfo[2] = result[0].road_address.address_name)
          : "";
        // 지번 주소
        placeInfo[3] = result[0].address.address_name;
      }
    });
  });
};

// 주소-좌표 변환 객체를 생성합니다
const geocoder = new kakao.maps.services.Geocoder();
// 좌표로 법정동 상세 주소 정보를 요청합니다
const searchDetailAddrFromCoords = (coords, callback) => {
  geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
};

const reloadMarker = () => {
  displayMarker();
};

const isValid = ref(true);
const notValid = () => {
  isValid.value = false;
};
</script>

<style scoped>
#map {
  margin: 0 auto;
  width: 43vw;
  height: 550px;
}

.flex-box {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  background-color: #f7fbf3;
  padding: 50px 0;
}

@media (max-width: 800px) {
  #map {
    justify-content: center;
    width: 100vw;
    height: 90vw;
  }
}

@media (max-width: 799px) {
  .commentList {
    margin-top: 40px;
  }
}
</style>
