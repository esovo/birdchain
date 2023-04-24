import { createWebHistory, createRouter } from "vue-router";
// import App from "../App.vue";
import HomeView from "@/views/Home.vue";
import DonateView from "@/views/DonateView.vue";
const routes = [
  {
    path: "/",
    name: "Post List",
    component: HomeView,
  },

  {
    path: "/Donate",
    name: "DonateView",
    component: DonateView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
