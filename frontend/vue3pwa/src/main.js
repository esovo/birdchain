import { createApp } from "vue";
import { createPinia } from 'pinia'
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
const vuetify = createVuetify({
  components,
  directives,
});
const app = createApp(App);
app.use(createPinia())
app.use(vuetify).use(router).use(Vue3Swiper);

app.mount("#app")
