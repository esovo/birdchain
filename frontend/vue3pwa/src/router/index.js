import { createWebHistory, createRouter } from "vue-router";
// import App from "../App.vue";
import HomeView from "@/views/HomeView.vue";
import BirdsView from "@/views/BirdsView.vue";
import MypageView from "@/views/MypageView.vue";
import DonateView from "@/views/DonateView.vue";
import GameView from "@/views/GameView.vue";
import GameOverView from "@/views/GameOverView.vue";
import NftView from "@/views/NftView.vue";

const routes = [
  {
    path: "/",
    name: "main",
    component: HomeView,
  },
  {
    path: "/birds",
    name: "birds",
    component: BirdsView,
  },
  {
    path: "/mypage",
    name: "mypage",
    component: MypageView,
  },
  {
    path: "/Donate",
    name: "DonateView",
    component: DonateView,
  },
  {
    path: "/game",
    name: "gameView",
    component: GameView,
  },
  {
    path: "/gameover",
    name: "gameover",
    component: GameOverView
  },
  {
    path: "/Nft",
    name: "NftView",
    component: NftView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
