package com.store.objectMap;

public class ObjectRepository {

	//Home page of apparel store
	public static class MyStore{
		public static final String signinBtn_name = "login";
		public static final String searchField_id = "search_query_top";
		public static final String searchFieldBtn_name = "button-search";
		public static final String userBtn_name = "account";
		public static final String signOutBtn_linkText = "Sign out";
		public static final String productContainer_name = "product-container";
		public static final String cartAccess_xpath = "//*[contains(@class, 'shopping_cart')]/a";
	}
	
	//Accounts page after login
	public static class Accounts{
		public static final String searchField_id = "search_query_top";
		public static final String userBtn_xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span";
		public static final String signOutBtn_linkText = "Sign out";
		public static final String homeBtn_linkText = "Home";
		public static final String alertMessage_name = "alert";
		public static final String signinBtn_name = "login";
	}
	
	//Sign In page after hitting sign in button
	public static class SignIn{
		public static final String createAccountEmail_id = "email_create";
		public static final String createAccountBtn_id = "SubmitCreate";
		public static final String loginEmail_id = "email";
		public static final String loginPassword_id = "passwd";
		public static final String loginBtn_id = "SubmitLogin";
		public static final String alertMessage_name = "alert";
	}
	
	//Register page after entering valid email for registering
	public static class createAccount{
		public static final String mrRadioBtn_id = "id_gender1";			//Not mandatory
		public static final String mrsRadioBtn_id = "id_gender2";			//Not mandatory
		public static final String firstName_id = "customer_firstname";
		public static final String lastName_id = "customer_lastname";
		public static final String password_id = "passwd";
		public static final String dropDownDays_id = "days";				//Not mandatory
		public static final String dropDownMonths_id = "months";			//Not mandatory
		public static final String dropDownYears_id = "years";				//Not mandatory
//		public static final String addressFirstName_id = "firstname";
//		public static final String addressLastName_id = "lastname";
		public static final String addressLine1_id = "address1";
		public static final String addressCity_id = "city";
		public static final String dropDownStates_xpath = "//*[@id=\"id_state\"]";
		public static final String addressPostalCode_id = "postcode";		
		public static final String dropDownCountry_id = "id_country";		//default selected
		public static final String mobilePhone_id = "phone_mobile";
		public static final String registerBtn_id = "submitAccount";
		public static final String userBtn_name = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span";
		public static final String alertMessage_name = "alert";
	}
	
	public static class Search{
		public static final String searchItemsContainer_xpath = "//div[@class='product-container']";
		public static final String searchItemsAlert_xpath = "//*[@id=\"center_column\"]/p";
		public static final String fashionManufacturer_xpath = "//*[@id=\"manufacturers_block_left\"]/div/ul/li/a";
	}
	
	public static class Item{
		public static final String reviewItem_xpath ="//*[@id=\"product_comments_block_extra\"]/ul/li/a";
		public static final String addToCartBtn_xpath = "//*[@id=\"add_to_cart\"]/button";
		public static final String continueShoppingBtn_name = "continue";
		public static final String stars_name = "star";
		public static final String commentTitle_id = "comment_title";
		public static final String commentContent_id = "content";
		public static final String commentSendBtn_id = "submitNewMessage";
		public static final String commentCheck_xpath = "//*[className=\"fancybox-inner\"]/p[1]";
		public static final String commentOkBtn_xpath = "//*[@id=\"product\"]/div[2]/div/div/div/p[2]/button";
		public static final String commentErrorMsg_id = "new_comment_form_error";
		public static final String homeBtn_name = "home";
		public static final String pinterestBtn_xpath = "//*[contains(@class, 'btn-pinterest')]";
		public static final String googlePlusBtn_xpath = "//*[contains(@class, 'btn-google-plus')]";
		public static final String facebookShareBtn_xpath = "//*[contains(@class, 'btn-facebook')]";
	}
	
	public static class Cart{
		public static final String proceedChkOutBtn_linkText = "Proceed to checkout";
		public static final String processAddress_tagName = "processAddress";
		public static final String processCarrier_tagName = "processCarrier";
		public static final String termsChkBox_id = "uniform-cgv";
		public static final String PayByBankWire_name = "bankwire";
		public static final String PayByCheque_name = "cheque";
		public static final String confirmOrderBtn_xpath = "//*[@id=\"cart_navigation\"]/button";
		public static final String successAlert_name = "alert-success";
	}

}
