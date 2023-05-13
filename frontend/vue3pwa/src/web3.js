import Web3 from "web3";
import { walletStore } from "@/stores/donationStore";

export async function createWeb3Instance() {
  let web3;
  const wStore = walletStore();

  const setwallet = (value) => {
    wStore.setwallet(value);
  }

  if (window.ethereum) {
    web3 = new Web3(window.ethereum);
    await window.ethereum.enable();
  } else if (window.web3) {
    web3 = new Web3(window.web3.currentProvider);
  } else {
    alert("이더리움 브라우저가 설치되지 않았습니다. MetaMask를 설치해주세요.");
    window.open("https://metamask.io/");
  }

  setwallet(web3.eth.getAccounts()[0]);

  return web3;
}

// export async function setupContract() {
//   const contractAddress = "스마트_컨트랙트_주소";
//   const ABI = [스마트_컨트랙트_ABI]; // JSON 형식의 ABI를 입력하세요.

//   contractInstance = new web3.eth.Contract(ABI, contractAddress);
// }
