<template>
  <div class="text-center">
    <v-dialog v-model="dialog" width="auto">
      <template v-slot:activator="{ props }">
        <v-btn v-bind="props" @click="getAccount" class="donate-button">
          기부하기
        </v-btn>
      </template>

      <v-card v-if="account.valueOf">
        <div class="donate-card">
          <img src="@/assets/img/Donate_dialog.png" class="v-card-img" />
          <v-card-text>
            <h1>기부할 금액을 설정해주세요.</h1>
            <h3>기부 최소 금액은 0.001 ETH입니다.</h3>
            <h2>현재 잔고 :</h2>
            <v-btn> 기부하기 </v-btn>
          </v-card-text>
        </div>
        <v-card-actions>
          <v-btn color="primary" block @click="dialog = false"
            >Close Dialog</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>
<script>
import { ref } from "vue";
import { createWeb3Instance } from "@/web3";
export default {
  setup() {
    const dialog = ref(false);

    const account = ref("");

    const getAccount = async () => {
      console.log("지갑 연동 실행");
      const web3 = await createWeb3Instance();
      if (web3) {
        const accounts = await web3.eth.getAccounts();
        console.log(accounts);
        account.value = accounts[0];
        dialog.value = true; // 올바르게 수정된 부분: dialog.value를 dialog로 수정
      }
    };

    return {
      dialog,
      account,
      getAccount,
    };
  },
};
</script>
<style scoped>
.donate-button {
  margin-top: 100px;
  font-size: 20px;
  padding: 60px, 100px;
}
.donate-card {
  display: flex;
  flex-direction: row;
}
.v-card-img {
  width: 300px;
  height: 300px;
}
</style>
