<!-- <template>
  <v-btn variant="outlined" @click="getAccount" class="donate-button">
    기부하기
  </v-btn>
</template>

<script>
import { createWeb3Instance } from "@/web3";
import { ref } from "vue";

export default {
  name: "DonateViewButton",

  setup() {
    const account = ref("");

    const getAccount = async () => {
      const web3 = await createWeb3Instance();
      if (web3) {
        const accounts = await web3.eth.getAccount();
        account.value = accounts[0];
      }
    };

    return {
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
</style> -->
