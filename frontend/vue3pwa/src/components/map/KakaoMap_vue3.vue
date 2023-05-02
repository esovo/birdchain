<!-- <template>
  <div>
    <div ref="map"></div>
  </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';

const mapRef = ref(null);

const initMap = () => {
  const container = mapRef.value;
  const options = {
    center: new kakao.maps.LatLng(36.354946759143, 	127.29980994578),
    level: 5,
  };

  //지도 객체를 등록합니다.
  //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
  const map = new kakao.maps.Map(container, options);
};

onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement("script");
    /* global kakao */
    script.onload = () => kakao.maps.load(initMap);
    script.src =
      `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}`;
    document.head.appendChild(script);
  }
});

</script>

<style scoped>
#map {
  margin: 0 auto;
  margin-top: 100px; /* 상단 여백 추가 */
  width: 1292px;
  height: 675.54px;
}
</style> -->