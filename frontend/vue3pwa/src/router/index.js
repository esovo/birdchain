import { createWebHistory, createRouter } from "vue-router";
// import App from "../App.vue";
import HomeView from "@/views/HomeView.vue";
import BirdsView from "@/views/BirdsView.vue";
import MypageView from "@/views/MypageView.vue";
import DonateView from "@/views/DonateView.vue";
import GameView from "@/views/GameView.vue";
import GameOverView from "@/views/GameOverView.vue";
import NftView from "@/views/NftView.vue";
import MapView from "@/views/MapView.vue";
// import testview from "@/views/TestView.vue";

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
    path: "/donate",
    name: "donateView",
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
    component: GameOverView,
  },
  {
    path: "/nft",
    name: "nftView",
    component: NftView,
  },
  {
    path: "/post",
    name: "MapView",
    component: MapView,
  },
  // {
  //   path: "/testview",
  //   name: "testview",
  //   component: testview,
  // },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
