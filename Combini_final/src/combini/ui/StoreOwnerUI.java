package combini.ui;

import java.util.Scanner;

import combini.service.StoreOwnerService;
import combini.vo.StoreOwner;

public class StoreOwnerUI {

	Scanner sc = new Scanner(System.in);
	private StoreOwnerService service = new StoreOwnerService();
	String er = "🚫";
	
	// register
	void register() {

		// column
		String owner_id = null;
		String owner_pwd, owner_name, owner_phone, branch_name;

		// receive values
		System.out.println("=====================");
		System.out.println("  [[  Register  ]]");
		System.out.println("=====================");
		
		// id
		boolean flag = true;
		int count = 0; // restrict 5 times

		while (flag) {
			System.out.print(" >> ID : ");
			owner_id = sc.nextLine();

			if (owner_id.length() < 4 || owner_id.length() > 10) {
				System.out.println(er + " Only 4 to 10 digits of ID are allowed.");
				count++;
			} else {
				flag = false;
			}
			
			if (count == 5) {
				System.out.println(er + " Please do again");
				return;
			}
		}
		
		// pwd ~
		System.out.print(" >> Password (under 10 digits) : ");
		owner_pwd = sc.nextLine();

		System.out.print(" >> Name : ");
		owner_name = sc.nextLine();

		System.out.print(" >> Phone number(ex. 000-0000-0000) : ");
		owner_phone = sc.nextLine();

		System.out.print(" >> Branch name : ");
		branch_name = sc.nextLine();

		// insert values to table
		StoreOwner owner = new StoreOwner();
		owner.setOwner_id(owner_id);
		owner.setOwner_pwd(owner_pwd);
		owner.setOwner_name(owner_name);
		owner.setOwner_phone(owner_phone);
		owner.setBranch_name(branch_name);

		// check the register is succeeded
		int result = service.register(owner);

		if (result == 1)  System.out.println(" ** Register is succeeded");
		else System.out.println(er + " Register is failed");

	}

	// login
	void login() {

		String id, pwd;
		
		// receive values
		System.out.println("=====================");
		System.out.println("    [[  Login  ]]");
		System.out.println("=====================");

		System.out.print(" >> ID : ");
		id = sc.nextLine();

		System.out.print(" >> Password : ");
		pwd = sc.nextLine();

		// insert values to new object for login
		StoreOwner owner = new StoreOwner();
		owner.setOwner_id(id);
		owner.setOwner_pwd(pwd);

		// receive object from DB data that id and pwd are matched
		StoreOwner ownerData = service.login(owner);

		// the exception when it receive the null to ownerData
		try {
			if (id.equals(ownerData.getOwner_id()) || pwd.equals(ownerData.getOwner_pwd()))
				System.out.println(" ** Login success");
		} catch (NullPointerException e) {
			System.out.println(er + " Please enter the correct id or password");
		}
	}
}
