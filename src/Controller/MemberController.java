package Controller;

import java.util.ArrayList;
import Member.MemberClass;
import ViewMember.ViewMember;

public class MemberController {
	ArrayList<MemberClass> memberList = new ArrayList<>();
	ViewMember vm = new ViewMember();
	
	void signUp(){
		vm.addMember();
	}

}
