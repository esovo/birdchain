import { createWebHistory, createRouter } from "vue-router";
// import App from "../App.vue";
import HomeView from "@/views/HomeView.vue";

const routes = [
  {
    path: "/",
    name: "Post List",
    component: HomeView,
  }

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;