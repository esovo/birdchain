<template>
  <div class="map-top">
    <img class="map-img" src="img/icons/bird-flying.gif" />
    <MarkerTypeButton
      @searchByType="searchByType"
      class="type-btn"></MarkerTypeButton>
  </div>
  <div class="map-intro">
    <div>
      <MapSearchBar
        @searchByAddress="searchByAddress"
        @searchCurPosition="searchCurPosition"
        :validAddress="validAddress"
        class="search-bar"></MapSearchBar>
      <div id="map" @click.once="movePin"></div>
    </div>
    <div class="map-intro-right">
      <div class="map-intro-text">
        버드스트라이크와 보호종 새를 발견하면 정보를 공유하는 게시판입니다.
        유리벽 충돌과 관련된 야생조류의 희생에 대한 정보를 공유해주세요. 우리나라의 도시밀집도와 이에 따른 건물 유리벽의 증가, 투명방음벽의 증가는 야생조류 개체군 몰락에 큰 영향을 미치는 것으로 보고 되고 있습니다. 주변에서 발생하는 야생조류 유리벽 충돌에 관한 정보를 모으는 데에 함께 동참해주세요.
        <br>
        보호종 새를 발견하면 해당 위치를 공유해주세요. 마커가 찍히는 횟수를 늘리고, 해당 장소의 환경보호에 함께 해요!
      </div>
      <div>
        <div class="info-regist">
          <div>
            지도 위를 클릭하여 <img src="img/icons/pin.png" class="info-img" /> 핀을
            움직여보세요.
          </div>
          <div>아래에 게시물을 작성할 위치의 주소가 표시됩니다.</div>
        </div>
        <MarkerRegist
          :placeInfo="placeInfo"
          :map="map"
          @reloadMarker="reloadMarker"></MarkerRegist>
      </div>
    </div>
  </div>
  <div class="flex-box">
    <div class="markerDetail">
      <div class="info-title">
        <img src="img/icons/free-icon-dove.png" class="info-post-img" />
        <div class="info-post">게시글 상세보기</div>
      </div>
      <MakerDetail
        v-if="isValid"
        :marker_id="marker_id"
        @reloadMarker="reloadMarker"
        @notValid="notValid"></MakerDetail>
    </div>
    <div class="commentList">
      <div class="info-title">
        <img src="img/icons/free-icon-letter.png" class="info-post-img"/>
        <div class="info-post">댓글달기</div>
      </div>
      <CommentList v-if="isValid" :marker_id="marker_id"></CommentList>
    </div>
  </div>
</template>

<script setup>
import MarkerTypeButton from "@/components/map/MarkerTypeButton.vue";
import MarkerRegist from "@/components/map/MarkerRegist.vue";
import MakerDetail from "@/components/map/MarkerDetail.vue";
import CommentList from "@/components/map/CommentList.vue";
import MapSearchBar from "@/components/map/MapSearchBar.vue";
import { ref, onMounted, reactive } from "vue";
import { getMarkersByType } from "@/api/markers";
const { kakao } = window;

// <지도 & 핀 생성하기>
var map = null;
const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(36.354946759143, 127.29980994578),
    level: 5,
  };
  //지도 객체를 등록합니다.
  map = new kakao.maps.Map(container, options);
};

var curMarker = null;
const makePin = () => {
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
//마커 이미지의 이미지 주소입니다
const imgSrc = "img/icons/feather.png";
// 마커 이미지의 이미지 크기 입니다
const imgSize = new kakao.maps.Size(60, 60);
// 마커 이미지를 생성합니다
const markersImage = new kakao.maps.MarkerImage(imgSrc, imgSize);
const displayMarker = (marker_type) => {
  // 기존에 있던 마커들 지우기
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }

  // axios 요청 보내서 DB 마커 가젹오기
  getMarkersByType(marker_type).then(({ data }) => {
    markerData.value = data.value;

    // 전달받은 위도&경도로 마커 생성하고 지도에 표시하기
    if (markerData.value.length > 0) {
      markerData.value.forEach((m) => {
        // 위도, 경도로 위치 정보를 생성
        var markerPosition = new kakao.maps.LatLng(m.lat, m.lng);
        const marker = new kakao.maps.Marker({
          map,
          position: markerPosition,
          image: markersImage,
        });

        // 마커에 클릭이벤트를 등록합니다
        kakao.maps.event.addListener(marker, "click", function () {
          isValid.value = true;
          marker_id.value = m.id;
          markerClickHandler(marker);
        });
        // 생성한 마커를 markers 배열에 추가하기
        markers.value.push(marker);
      });
    }
  });
};
// 이전에 선택한 마커의 참조 변수
var previousMarker = null;

// 클릭한 마커 상태 변경
const markerClickHandler = (marker) => {
  // 이전에 선택한 마커가 있으면 크기를 원래 크기로 돌리기
  if (previousMarker) {
    previousMarker.setImage(markersImage); // markersImage는 이전에 생성한 마커 이미지 객체입니다
  }

  // 선택한 마커의 이미지 크기를 변경하기
  const clickImageSize = new kakao.maps.Size(100, 100); // 크기를 변경할 값으로 설정합니다
  const clickMarkerImage = new kakao.maps.MarkerImage(imgSrc, clickImageSize);
  marker.setImage(clickMarkerImage);

  // 선택한 마커를 이전에 선택한 마커 변수에 저장하기
  previousMarker = marker;
};

onMounted(() => {
  initMap();
  makePin();
  displayMarker("");
});

// <클릭한 위치 위도, 경도, 법정동 주소 가져오기>
const placeInfo = reactive([]);
const movePin = () => {
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
  displayMarker("");
};

const isValid = ref(true);
const notValid = () => {
  isValid.value = false;
};

// <현위치로 위치 검색하기>
const validAddress = ref(false);
const searchCurPosition = () => {
  // HTML5의 geolocation으로 사용할 수 있는지 확인합니다
  if (navigator.geolocation) {
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function (position) {
      var lat = position.coords.latitude, // 위도
        lng = position.coords.longitude; // 경도
      var locPosition = new kakao.maps.LatLng(lat, lng); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
      map.setCenter(locPosition);
      curMarker.setPosition(locPosition);
      validAddress.value = false;
      placeInfo[0] = lat;
      placeInfo[1] = lng;
      searchDetailAddrFromCoords(locPosition, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          // 도로명 주소
          result[0].road_address
            ? (placeInfo[2] = result[0].road_address.address_name)
            : "";
          // 지번 주소
          placeInfo[3] = result[0].address.address_name;
        }
      });
    });
  } else {
    // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    validAddress.value = true;
    var locPosition = new kakao.maps.LatLng(36.354946759143, 127.29980994578);
    map.setCenter(locPosition);
    curMarker.setPosition(locPosition);
  }
};

// <키워드로 위치 검색하기>
const searchByAddress = (keyword) => {
  // 장소 검색 객체를 생성합니다
  var ps = new kakao.maps.services.Places();
  // 키워드로 장소를 검색합니다
  ps.keywordSearch(keyword, placesSearchCB);
  // 키워드 검색 완료 시 호출되는 콜백함수 입니다
  function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
      pagination;
      placeInfo[0] = data[0].y; // 위도
      placeInfo[1] = data[0].x; // 경도
      var locPosition = new kakao.maps.LatLng(data[0].y, data[0].x);
      map.setCenter(locPosition);
      curMarker.setPosition(locPosition);
      searchDetailAddrFromCoords(locPosition, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          // 도로명 주소
          result[0].road_address
            ? (placeInfo[2] = result[0].road_address.address_name)
            : "";
          // 지번 주소
          placeInfo[3] = result[0].address.address_name;
        }
      });
    }
  }
};

// <타입별로 마커 검색하기>
const searchByType = (data) => {
  if (data.length == 2) {
    displayMarker("");
  } else if (data.length == 0) {
    displayMarker("");
  } else {
    displayMarker(data[0]);
  }
};
</script>

<style scoped>
.map-top {
  display: flex;
  justify-content: space-between;
  width: 78vw;
  margin: 0 auto;
}
.map-img {
  width: 12vw;
  height: 12vw;
}

.map-intro {
  display: flex;
  justify-content: center;
  margin: 0 auto;
  width: 80vw;
}

.map-intro-text {
  width: 26vw;
  margin: 0 auto 40px auto;
}

.map-intro-right {
  margin: auto 0;
}

#map {
  margin: 0 auto;
  width: 50vw;
  height: 550px;
}

.search-bar {
  width: 50vw;
  margin: 0 auto;
}

.flex-box {
  width: auto;
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  background-color: #f7fbf3;
  padding: 50px 0;
}

.markerDetail {
  margin-right: 70px;
}

.commentList {
  margin-left: 70px;
}

.info-regist {
  font-size: 1.5vw;
  margin: 10px auto 0 auto;
  width: 31vw;
}

.info-img {
  width: 2.5w;
  height: 2.5vw;
}

.info-post {
  font-size: 1.5vw;
  margin: auto 0;
}

.info-post-img {
  width: 4vw; 
  height: 3.5vw;
  margin-right: 10px;
}
.info-title {
  margin-top: 20px;
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
  width: 450px;
}

@media (max-width: 800px) {
  #map {
    justify-content: center;
    width: 100vw;
    height: 90vw;
  }
  .search-bar {
    width: 100vw;
    margin: 0 auto;
  }
  .map-top {
    width: 100vw;
  }
  .markerDetail {
    margin-right: 0;
  }
  .commentList {
    margin-left: 0px;
  }
  .map-intro {
    flex-wrap: wrap;
    width: 100vw;
  }
  .map-intro-text {
    width: 55vw;
  }
  .info-regist {
    width: 55vw;
  }
  .map-intro-right {
    margin-top: 10px;
  }
}

@media (max-width: 1062px) {
  .markerDetail {
    margin-right: 0;
  }
  .commentList {
    margin-left: 0px;
  }
  .info-post {
    font-size: 3vw;
  }
  .info-regist {
    font-size: 3vw;
  }
  .map-info-text {
    font-size: 3vw;
  }
}
</style>
