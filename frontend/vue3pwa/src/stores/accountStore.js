import { defineStore } from "pinia";

export const useAccountStore = defineStore({
  id: "account",

  state: () => ({
    account: null,
  }),
  getters: {
    isConnected: (state) => state.account !== null,
  },
  actions: {
    setAccount(account) {
      this.account = account;
    },
  },
});
