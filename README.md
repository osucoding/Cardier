# Cardier

사업계획안 Briefly 

Mobile Application

Name - Whose (후즈), Who’s app

Application -> Design (Figma) , Reference, 디자이너 있으면 초대 해주셔도 됩니다.

Description:

현재, 우리가 디지털 세대를 살고있습니다

다만, 아직도 명함 같은 경우는 종이 명함을 쓰는 경우가 많아요 근데 또 여기서 문제점
요즘 애플페이, 삼성페이가 활성화가 됐기 때문에 사람들이 지갑을 잘 안 들고다녀
들고 다녀도 카드 지갑 (조그만한거 들고 다님). 이 문제를 해결하기 위해서,
저희는 핸드폰에 명함을 넣을 수 있는 시스템 그리고 애플리케이션을 통해서 명함 공유가 가능한 시스템을 만들려고 합니다. 

Use cases:

승우, 민준 <- 개인정보에 대한 보안 대책.

MVP <- (Minimum Viable Product)  

유저와 유저간의 명함 공유 (QR Code, 아이디)
유저의 명함 등록 <- 회사 이메일 인증 필요 
다른 유저의 명함을 등록할 때 Description(설명란)을 추가해서 이제 이 사람이 내가 왜 언제 뭐 때문에 만났는지 기억 할 수 있도록 적어 놓는 기능.
아이디를 통해서 명함 공유도 가능하고
명함을 생성할때 회사 이메일 (Verified mark)
—----------------------------------------------------------------------------------------- 
부서에 대한 카테고리는 좀 힘들껀데 회사 Sorting - Filter
명함에 추가 할 수 있는 프로필 사진 ->
명함이라는 이미지가 원래 직사각형 -> 명함으로 보여주고 
클릭을 하면 애니메이션 되면서 명함이 360 회전하고 뒤에는 사진이랑 설명란 보여주는.
개인 사업자? 프리랜서? 사람들이 개인 이메일로 하고 회사를 뻥카 칠까봐.
기준이 확실해야함 -> 어떻게 개인 이메일인데 회사를 거짓말 안치고 구분을 할 수 있는지.
한 사람이 앱을 가지고있어도 QR code 통해서 연락처 추가 가능하게 
API 오픈 소스가 되면 <- 기기 끼리 네임드랍 가능하게
Privacy 문제로 내가 다른 사람의 명함을 삭제할시 그 사람도 내 명함 삭제되는 기능.


Tech Stack
IOS (민준), Android ( 승우랑, 나 ), 개발 인원은 추가 가능 

FrontEnd

2 ) API for Known Company Domains:
https://github.com/gigasheetco/fortune-500-domains/blob/main/fortune-500-domains

Android (Kotlin)
IOS (SwiftUI)

Backend


SpringBoot Java 
Github (VC), Action CI/CD
AWS, Heroku, Google Cloud 


