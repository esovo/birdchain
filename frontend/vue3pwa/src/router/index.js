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
import { useAccountStore } from "@/stores/accountStore";

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
    beforeEnter: (to, from, next) => {
      const storedImages = localStorage.getItem("images");
      if (storedImages) {
        next({ name: "nftView" });
      } else {
        next();
      }
    },
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
    beforeEnter: (to, from, next) => {
      // ...
      const images = localStorage.getItem("myNFTImages");
      const accountStore = useAccountStore();

      if (images || accountStore.hasDonated) {
        next();
      } else {
        next({ name: "donateView" });
      }
    },
  },
  {
    path: "/post",
    name: "MapView",
    component: MapView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
