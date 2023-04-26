// import { createPinia } from 'pinia'
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router/index.js";
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";
import Vue3Swiper from "vue3-swiper";
import "swiper/swiper-bundle.css";
import "@mdi/font/css/materialdesignicons.css";
import { createApp } from "vue";

// FontAwesome 관련 임포트
import { library } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

const vuetify = createVuetify({
  components,
  directives,
});
library.add(fas);
// App.use(createPinia())
const app = createApp(App);

// FontAwesome 전역 컴포넌트 등록
app.component("font-awesome-icon", FontAwesomeIcon);
// app.use(createPinia())
app.use(vuetify).use(router).use(Vue3Swiper).mount("#app");
