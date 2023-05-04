// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract Donation is ERC20 {
    address payable public donationReceiver;

    event DonationReceived(address sender, uint amount);
    event MyCurrentValue(address _msgSender,uint256 _value);

  constructor(string memory name, string memory symbol) ERC20(name, symbol) {
    donationReceiver = payable(0xadA2C5024608A5dD321b960c22CC297c31dF4422);
  }

    //기부
    function donate() public payable {
        require(msg.value > 0, "DonationToken: amount must be greater than 0");
        require(msg.sender.balance >= msg.value, "DonationToken: insufficient balance");
        donationReceiver.transfer(msg.value);
        emit DonationReceived(msg.sender, msg.value);
    }

    //잔고확인
    function checkValueNow() public {
        emit MyCurrentValue(msg.sender, msg.sender.balance);
    }
}