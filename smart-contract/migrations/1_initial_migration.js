const Migrations = artifacts.require("./Migrations.sol");
const Donation = artifacts.require("./Donation.sol");

module.exports = function (deployer) {
  deployer.deploy(Migrations);
  deployer.deploy(Donation, "Donation", "DNT"); 
    // deployer.deploy(Donation); 
  // deployer.deploy(SsafyToken, "SSAFY", "SSF", 0);
};
