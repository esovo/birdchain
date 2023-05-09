// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract Donation is ERC20, Ownable {
    address payable public donationReceiver;

    event DonationReceived(address sender, uint amount, uint totalContribution);
    event MyCurrentValue(address _msgSender,uint256 _value);

  constructor(string memory name, string memory symbol) ERC20(name, symbol) {
    donationReceiver = payable(0xadA2C5024608A5dD321b960c22CC297c31dF4422);
  }

   //지금 msg.sender가 누구인지 확인
   function confirm() public view returns (address add) {
      return msg.sender;
   }

    //기부
    function donate() public payable onlyOwner{
        require(msg.value > 0, "DonationToken: amount must be greater than 0");
        require(msg.sender.balance >= msg.value, "DonationToken: insufficient balance");
        // donationReceiver.transfer(msg.value);
        _transfer(msg.sender, donationReceiver, msg.value);
        emit DonationReceived(msg.sender, msg.value, donationReceiver.balance);
    }

    //잔고확인
    function checkValueNow() public {
        emit MyCurrentValue(msg.sender, msg.sender.balance);
    }

}