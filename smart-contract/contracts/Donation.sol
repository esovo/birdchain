// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";

contract DonationToken is ERC20 {
    address payable public donationReceiver;

    event DonationReceived(address sender, uint amount);
    event MyCurrentValue(address _msgSender,uint256 _value);

   constructor(string memory name, string memory symbol, address payable _donationReceiver) ERC20(name, symbol) {
        donationReceiver = _donationReceiver;
    }

    //기부
    function donate() public payable {
        require(msg.value > 0, "DonationToken: amount must be greater than 0");
        require(balanceOf(msg.sender) >= msg.value, "DonationToken: insufficient balance");
        transfer(donationReceiver, msg.value);
        emit DonationReceived(msg.sender, msg.value);
    }

    //잔고확인
    function checkValueNow() public{
        emit MyCurrentValue(msg.sender, msg.sender.balance);
    }
}