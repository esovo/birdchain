import { createWebHistory, createRouter } from "vue-router";
// import App from "../App.vue";
import HomeView from "@/views/Home.vue";

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