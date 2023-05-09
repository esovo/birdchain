// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract Donation is ERC20, Ownable {
    address payable public donationReceiver;
    uint totalContribution;

    event DonationReceived(address sender, uint amount);
    event MyCurrentValue(address _msgSender,uint256 _value);
    event EtherReceived(address sender, uint256 amount);

  constructor(string memory name, string memory symbol) ERC20(name, symbol) {
    donationReceiver = payable(0xadA2C5024608A5dD321b960c22CC297c31dF4422);
  }

  //Contract 자체 이더 조회
  function getContractBalance() public view returns (uint256) {
    return address(this).balance / 1 ether;
  }

   function getTotalContribution() public view returns (uint total) {
      return totalContribution;
   }

    //콘트렉트 자체에 이더 송금하면 자동으로 발동하는 함수 여러가지를 처리할 수 있음
    receive() external payable {
        emit EtherReceived(msg.sender, msg.value);
    }

     //콘트렉트 자체에 이더 송금
     function sendEtherToContract(address payable contractAddress) external payable {
        contractAddress.transfer(msg.value);
    }

    //기부
    function donate() public payable onlyOwner {
        require(msg.value > 0, "DonationToken: amount must be greater than 0");
        require(msg.sender.balance >= msg.value, "DonationToken: insufficient balance");
        donationReceiver.transfer(msg.value);
        totalContribution+=msg.value / 1 ether;
        emit DonationReceived(msg.sender, msg.value);
    }

    //잔고확인
    function checkValueNow() public view onlyOwner returns(uint balance){
        return msg.sender.balance / 1 ether;
    }
}