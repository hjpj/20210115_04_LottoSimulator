package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		로또 시뮬레이터 제작
		
//		1) 내 번호 6개 입력
		
//		내 숫자 6개 저장 배열
		int[] myNumberArr = new int[6];
		
//		컴퓨터 자원 낭비를 막기 위해, Scanner는 for문 밖에서 생성.
		Scanner myScanner = new Scanner(System.in);
		
		for (int i = 0; i< myNumberArr.length ; i++) {

			
//			제대로 된 숫자가 들어올 때까지 -> 각 숫자를 계속 반복으로 받아야함.
			
			while(true) {
				
				System.out.print((i+1) + "번째 숫자 입력 : ");
				
//				숫자 입력받기.
				
				int inputNum = myScanner.nextInt();
				
//				1. 1 ~ 45의 범위인가?
				
				boolean isRangeOk = (1 <= inputNum) && (inputNum <= 45);
				
//				2. 이미 등록된 숫자가 아닌가? => 중복이 아닌가?
				
				boolean isDuplOk = true; // 일단 써도 된다고 전제 -> 중복임을 발견하면, 쓰면 안된다고 변경.
				
//				내 번호목록을 돌아보다가 => 입력한 숫자와 같은게 있다면> => 이미 등록된 숫자. (중복) => 사용하면 안됨.
				
				for(int myNum : myNumberArr) {
					
					if(myNum == inputNum) {
						
//						같은걸 발견! => 중복
						isDuplOk = false;
						
						
//						더 이상 검사할 필요 X
						break;
					}
				}
				
//				1, 2를 모두 통과하면 => 내 번호 배열에 등록 + 다음 숫자로 이동.
				
				if (isRangeOk && isDuplOk) {
					
//					검사 통과 상황.
					
//					내 번호 목록에 -> 입력한 숫자를 기록.
					myNumberArr[i] = inputNum;
					
//					무한반복 종료 -> 다음 숫자로 이동.
					break;
					
					
				}
				else if(!isRangeOk) {
					
//					범위 검사에 탈락?
					System.out.println("로또는 1~45의 숫자만 입력 가능합니다.");
					
				}
				else {
//					통과 X, 범위검사 O => 중복검사에서 탈락.
					
					System.out.println("중복된 숫자는 입력할 수 없습니다.");
				}
				
				
			}
		
			

//			내 번호를 자리에 입력받아 넣자. => Scanner 필요. (밖에서 생성)
			
//			몇 번째 숫자? 안내문.
			

			
		}
		
//		내 번호 6개 입력 완료.
		
//		당첨번호 6개 생성 => 임시로, 숫자 6개 고정.
		

		
//		int[] winNumberArr = { 2, 7, 15, 30, 35, 40};

//		실제로 랜덤 6개 생성(당첨번호 뽑기)
		
		int[] winNumberArr = new int[6];
		
//		6개의 랜덤 숫자
		
		for(int i = 0; i<winNumberArr.length; i++) {
			
//			랜덤도 사용가능한 수가 나올때까지 반복
		
			while(true) {
				
//				컴퓨터에게 1~45 랜덤 추출 요청.
				
//				Math.random()*45 + 1 => int로 강제변환 (소수점 버림): 0 <= (정수)결과물 * 45 < 45 : 1~45				
				int randomNum =(int) (Math.random() * 45 + 1); //캐스팅(Casting) => int로 형 변환 수행.
						
//				랜덤숫자를 중복검사 수행.
//				당첨번호에, 랜덤숫자와 같은게 있다면? 중복검사 탈락.
				
				boolean isDuplOk = true;
				
				for(int winNum : winNumberArr) {
					
					if(winNum == randomNum) {
						
						isDuplOk =false;
						
						break;
					}
					
				}
						
//				중복검사에 통과하면, 다음 숫자.
			
				if(isDuplOk) {
					
//					당첨번호에 랜덤숫자 등록
					winNumberArr[i] = randomNum;
					
					break;
							
				}
			
			}
		
		}
		
//		당첨번호 6개는 뽑힌 상황.
//		추가로 보너스번호도 뽑자. => 제대로 된 번호 하나가 나올때까지 반복.
		
//		보너스번호를 저장할 변수
		int bonusNum = 0;
		
		while(true) {
			
			int randomNum = (int)(Math.random() * 45 + 1);
			
//			중복검사 수행.
			boolean isDuplOk = true;
			
			for(int winNum : winNumberArr) {
				
				if(winNum == randomNum) {
					isDuplOk = false;
					break;
				}
			}
			
			
		}
		
		if(isDuplOk) {
//			보너스번호로 지정.
			bonusNum = randomNum;
			
			break;
		}
//		당첨번호 오름차순 정렬 - Bubble Sort

//		동작속도는 느리지만, 코딩하기가 편한 로직.
		
		for(int i = 0; i < winNumberArr.length; i++) {
			
//			j가 5인 경우 => j+1은 6임. => 배열 범위를 벗어남.
//			j가 길이 보다 2개 적은 값 까지만 돌도록.
			
			for(int j = 0; j < winNumberArr.length-1; j++) {
				
//				이어져있는 2개의 숫자를 비교, 순서가 잘못되어있다면 바꿔주자.
				
				if(winNumberArr[j] > winNumberArr[j+1]) {
					
//					두 변수의 값 교환.
					
					int backup = winNumberArr[j];
					
					winNumberArr[j] = winNumberArr[j+1];
					
					winNumberArr[j+1] = backup;
				}
			}
		}
//		확인용 - 당첨번호가 어떻게나왔는지?
		
		for(int winNum : winNumberArr) {
			System.out.println(winNum);
		}
		
		
		
//		등수 판정 하기.
		
//		내 번호 하나를 들고 => 당첨번호 비교 6회 반복. => 내 번호 6개에 대해서 통째로 반복. (for 중첩)
		
//		배열의 내용물을 꺼내보는 for
		
//		맞춘 갯수를 기록 변수.
		
		int correctCount = 0;
		
		for(int myNum : myNumberArr) {
			
			for(int winNum : winNumberArr) {
				
//				내 숫자와, 당첨번호가 같은가?
				
				if(myNum == winNum) {
					
//					같은 숫자 하나 추가 발견!
					
					correctCount++;
				}
			}
		}
		
		System.out.println(correctCount + "개 맞춤!");
		
//		맞춘 갯수에 따른 등수 출력
		
		if (correctCount == 6) {
			System.out.println("1등");
		}
		else if(correctCount == 5) {
			
//			보너스 번호를 맞췄는지? 추가 검사 필요.
			
			boolean isBonusCorrect = false; // 내 번호중 하나가 보너스번호라면 true로 변경.
			
			for(int myNum : myNumberArr) {
				
//				내 번호들을 => 보너스번호와 같은가?
				if(myNum == bonusNum) {
//					보너스번호 맞춤!
					
					isBonusCorrect = true;
					break;
					
				}
			}
			
//			보너스번호 맞춘 여부에 따른 등수 출력.
			
			if(isBonusCorrect) {
				System.out.println("2등");
			}
			else {
				System.out.println("3등");
			}
		}
		else if(correctCount == 4) {
			System.out.println("4등");
		}
		else if(correctCount == 3) {
			System.out.println("5등");
		}
		else {
			System.out.println("낙첨");
		}
		
		
	}

}
