<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="background-color:rgb(223, 220, 213);margin-top:0;">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    @media yahoo {
    table {border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt; table-layout: fixed;}
    table table { table-layout: auto; }
    }
    
    @charset "UTF-8";
body{
  padding: 0;
  margin: 0;
}
div{
  box-sizing: border-box;
}



/* 멤버쉽 등급 */
.grade{
  color: #FAED7D;
}

.wrap{
  background-color: #F8F8F8;  
}
/* 검정배경 */
.blackContainer{  
  height: 132px;
  background-color: #000000;  
  
  display: flex;
  align-items: flex-end;
  padding: 16px;
}

.blackContainer .name{
   font-size: 20px;
  font-weight: bold;
  color: #ffffff;
  
} 
.blackContainer .modify{
  margin-left: auto;
}

/* 찜목록 , 1:1 문의 내역 , 적립금 박스 */
.summaryContainer{
  background-color: white;  
  display: flex;  
  padding: 21px 16px;  
  height: 90px;
  margin-bottom: 10px;
}

/*  숫자 */
.summaryContainer .number{
  font-size: 19px;
  font-weight: bold;
  color: #000000;
}
/* 텍스트 */
.summaryContainer .item > div:nth-child(2){
  font-size: 13px;
}


/*=================== 회원정보~ 내지갑 리스트 ==================*/
.listContainer{  
  padding: 0;
  background-color: #ffffff;
  margin-bottom: 10px;
}
.listContainer .item{  
  display: flex;
  align-items: center;
  padding: 16px;
  color: black;
  text-decoration: none;  
  height: 56px;
  box-sizing: border-box;
}
.listContainer .icon{  
  margin-right: 14px;
}
.listContainer .text{
  font-size: 16px;
  position: relative;
}
.listContainer .right{
  margin-left: auto;
}
    
  body, .container, html {
    background-color: #DFDCD5;
    margin-top: 0;
  }
  .container {
    padding: 10px 10px 0 10px;
  }
  img {
    -ms-interpolation-mode: bicubic;
    border: none;
    outline: none;
  }
  .desktop-hide, .desktop-hide img {
    height: 0 !important;
    width: 0 !important;
    line-height: 0 !important;
    font-size: 0 !important;
    padding: 0 !important;
    overflow: hidden !important;
  }
  @media (max-width: 480px) {
    .ios-hide {
      display: none;
    }
  }
  a {
    color: inherit !important;
  }
  a img {
    border-style: none;
  }
  .copy a {
    font-family: Helvetica, Arial, sans;
    font-weight:normal;
    text-decoration: underline !important;
    color: #221F1F !important;
  }
  
  /* Content */
  body {
    font-family: Helvetica, Arial, sans;
    color: #221F1F;
  }
  .content-shell, .shell {
    background-color: #ffffff;
    border-radius: 5px !important;
  }
  .content-shell-footer, .shell-footer {
    background-color: #DFDCD5;
  }
  .content {
    font-size: 14px;
    line-height: 22px;
    color: #221F1F;
    font-family: Helvetica, Arial, sans;
  }
  .caps {
    font-size: 12px;
    line-height: 22px;
    font-weight: bold;
  }
  .shadow-white {
    background-color: #ffffff;
  }
  .help-center-link {
    text-decoration: underline;
    font-weight: bold;
  }
  @media (max-width: 569px) {
    .ios-hide-max {
      display: none;
    }
    .inbox-fix {
      display: none;
    }
    .shell, .shell-footer {
      width: 94% !important;
    }
    .container, body {
      margin: 0 !important;padding: 10px 0px 0px 0px !important;
    }
  }
  @media (max-width: 480px) {
    .copy {
      padding-left: 26px !important;
      padding-right: 26px !important;
    }
  }
 
      .spacer-one {
    line-height: 10px;
    font-size: 10px;
  }/* Logo */
  .logo {
    padding: 26px 0 0 0;
  }
  @media (max-width: 480px){
    .logo {
      padding: 26px 26px 0 26px !important;
    }
    .logo img {
      width: 95px;
    }
  }
  /* View All Bar */
  .view-all-bar-shell {
    padding: 0 0 0 0;
    background-color: #DFDCD5;
  }
  .view-all-bar {
    width: 570px;
    background-color: #666666;
    border-radius: 0 0 5px 5px;
  }
  .view-all-bar td.bar{
    padding: 10px;
    font-size: 20px;
    color: #ffffff;
    text-align: center;
    border-radius: 8px;
  }
  .view-all-bar td.bar a {
    color: #ffffff;
    text-decoration: none;
  }
  .view-all-bar-shell .shadow {
    vertical-align: top !important;
  }
  .bottom-padding {
    line-height: 26px;
    font-size: 26px;
  }
  @media (max-width: 569px) {
    .view-all-bar, .view-all-shadow {
      width: 100% !important;
  
    }
    .view-all-shadow tr td {
      vertical-align: top;
    }
    .view-all-shadow tr td img {
      width: 100%;
    }
  
    .view-all-bar-shell {
      padding: 0 0 0 0 !important;
    }
  }
  @media (max-width: 480px) {
    .view-all-bar td.bar {
      font-size: 19px !important;
    }
    .view-all-bar-shell {
      padding: 0 0 0 0 !important;
    }
  }
  @media (max-width: 320px) {
    .view-all-bar-shell .bar a {
      font-size: 16px !important;
    }
    .view-all-chevron {
      width: 8px !important;
    }
  }
  td.copy {
    padding: 22px 30px 0 30px;
    color: #221F1F;
  }
  @media (max-width: 480px) {
    .copy {
      padding: 10px 26px 0 26px !important;
    }
  }
  </style>
</head>

<body bgcolor="#DFDCD5" style="font-family:Helvetica, Arial, sans;color:rgb(34, 31, 31);background-color:rgb(223, 220, 213);margin-top:0;">

<div class="wrap">
  <div class="blackContainer">
    <div>
      <div class="grade">${mvo.grade }</div> 
      <div class="name">${vo.nick}</div>
    </div>    
    
  </div>

    
  </div>  
  <div class="listContainer">
    <a href="${cp }/user/update?id_pk=${vo.id_pk }" class="item">
        <div class="text">회원정보 수정</div>
        <div class="right"> ></div>
    </a>
  </div>

  <!--/* 100% Size Container -->
  <table class="container" width="100%" cellpadding="0" cellspacing="0" border="0" style="padding:10px 10px 0 10px;background-color:rgb(223, 220, 213);margin-top:0;">
    <tbody>
      <tr>
        <td align="center">
          <!--/* Hero + Content -->
          <table class="shell" width="570" cellpadding="0" cellspacing="0" border="0" style="background-color:rgb(255, 255, 255);border-radius:5px;">
            <!--/* Content -->
            <tbody>
              <tr>
                <td class="content-shell" style="background-color:rgb(255, 255, 255);border-radius:5px;">
                  <table class="content" width="100%" cellpadding="0" cellspacing="0" border="0" style="font-size:14px;line-height:22px;color:rgb(34, 31, 31);font-family:Helvetica, Arial, sans;">
                    <!--/* Logo -->
                    <tbody>
                      <tr>
                        <td class="logo" align="center" style="padding:26px 0 0 0;">
                            <img src="${cp }/home/assets/imgs/LOGO.PNG" alt="Five Guys Team" width="140" align="center" style="-ms-interpolation-mode:bicubic;border:none;outline:none;border-style:none;">
                          </a>
                        </td>
                      </tr>
                      <tr>
                        <td class="spacer-one" style="line-height:10px;font-size:10px;">
                          <br>
                        </td>
                      </tr>
                      <tr>
                        <td class="copy" style="padding:22px 30px 0 30px;color:rgb(34, 31, 31);">저희 영화 홈페이지를 이용해주시는 모든 분들에게, </td>
                      </tr>
                      <tr>
                        <td class="copy" style="padding:22px 30px 0 30px;color:rgb(34, 31, 31);">저희 회사는 선진화된 관람문화와 최고의 서비스로 고객에게 잊을 수 없는 감동을 선사합니다.</td>
                      </tr>
                      <tr>
                        <td class="copy" style="padding:22px 30px 0 30px;color:rgb(34, 31, 31);">저희만이 제공할 수 있는 다양한 즐거움과 특별한 경험을 통해 고객의 Lifestyle을 풍요롭게 만듭니다.
                        
                      </tr>
                      <tr>
                        <td class="copy" style="padding:22px 30px 0 30px;color:rgb(34, 31, 31);">언제나 질문이 있으시면 기꺼이 도와드리겠습니다.
                     </td>
                      </tr>
                      <tr>
                        <td class="copy" style="padding:22px 30px 0 30px;color:rgb(34, 31, 31);">– Five Guys Team</td>
                      </tr>
                      <tr>
                        <td class="spacer">
                          <br>
                        </td>
                      </tr>
                      <!--[if !mso]>
                          <!-->
                      <style type="text/css">
                        @media all and (max-width: 569px) {
                              .title-row-table {width: 100% !important;}
                              table[class=boxArt] { width:100% !important; padding: 0 30px 0 30px; }
                              td[class=resize1] img { width: 100% !important; height: auto !important;padding:0px 2px 0px 0px !important; }
                              td[class=resize2] img { width: 100% !important; height: auto !important;padding:0px 0px 0px 0px !important; }
                              .off { display: none;}
                          
                            }
                      </style>
                      <!--<![endif]-->
                     
                      <!--/* View All Bar -->
                      <tr>
                        <td class="view-all-bar-shell" style="padding:0 0 0 0;background-color:rgb(223, 220, 213);">
                          <table class="view-all-bar" align="center" width="570" cellpadding="0" cellspacing="0" border="0" style="width:570px;background-color:rgb(102, 102, 102);border-radius:0 0 5px 5px;">
                            <tbody>
                              <tr>
                                <td width="2.5%">&nbsp;</td>
                                <td class="bar" width="95%" style="padding:10px;font-size:20px;color:rgb(255, 255, 255);text-align:center;border-radius:8px;">
                                  <a href="${cp }/home" style="color:rgb(255, 255, 255);text-decoration:none;color:inherit;">View All Movies &nbsp;
                                      <img class="view-all-chevron" alt=">" src="http://cdn.nflximg.com/us/email/welcome_mountain/cf/chevron.png"
                                      width="11" style="border-collapse:collapse;-ms-interpolation-mode:bicubic;border:none;outline:none;border-style:none;">
                                    </a>
                                </td>
                                <td width="2.5%">&nbsp;</td>
                              </tr>
                            </tbody>
                          </table>
                          <table class="view-all-shadow" align="center" width="570" cellpadding="0" cellspacing="0" border="0">
                            <tbody>
                              <tr>
                                <td width="2.5%">&nbsp;</td>
                                <td class="shadow" width="95%" style="-ms-interpolation-mode: bicubic;border: none;outline: none;line-height:0;font-size:0;vertical-align:top;">
                                  <img src="http://cdn.nflximg.com/us/email/logo/newDesign/shadow.png" width="540" style="border-collapse:collapse;display:block;-ms-interpolation-mode:bicubic;border:none;outline:none;">
                                </td>
                                <td width="2.5%">&nbsp;</td>
                              </tr>
                            </tbody>
                          </table>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </td>
              </tr>
            </tbody>
          </table>
 
        </td>
      </tr>
    </tbody>
  </table>
  <!-- Fix for Google Inbox -->
  <table class="inbox-fix" cellpadding="0" cellspacing="0" border="0" width="570" height="1" align="center" style="width: 570 !important;">
    <tbody>
      <tr>
        <td>
          <img src="http://cdn.nflximg.com/us/email/spacer.gif" width="190" height="1" style="border-collapse:collapse;display:block;-ms-interpolation-mode:bicubic;border:none;outline:none;">
        </td>
        <td>
          <img src="http://cdn.nflximg.com/us/email/spacer.gif" width="190" height="1" style="border-collapse:collapse;display:block;-ms-interpolation-mode:bicubic;border:none;outline:none;">
        </td>
        <td>
          <img src="http://cdn.nflximg.com/us/email/spacer.gif" width="190" height="1" style="border-collapse:collapse;display:block;-ms-interpolation-mode:bicubic;border:none;outline:none;">
        </td>
      </tr>
    </tbody>
  </table>
</body>
</html>