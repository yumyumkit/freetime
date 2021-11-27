import time
import csv
from  selenium.webdriver.common.keys import Keys
from selenium import webdriver




# browser = webdriver.Chrome('C:/chromedriver.exe')
#
# # 웹사이트 오픈
# browser.get('https://www.naver.com')
# browser.implicitly_wait(10) # 로딩 10초 대기
#
# # 쇼핑메뉴 클릭
# browser.find_element_by_css_selector('a.nav.shop').click()
# time.sleep(2)
#
# # 검색창 클릭 + 변수
# search = browser.find_element_by_css_selector('input.co_srh_input._input')
# search.click()
#
# # 검색어
# search.send_keys('매트리스')
# search.send_keys(Keys.ENTER)
#
# # 스크롤 하기 전
# before_h = browser.execute_script("return window.scrollY")
#
# # 스크롤 반복
# while True:
#     # 끝까지 스크롤 ↓
#     browser.find_element_by_css_selector("body").send_keys(Keys.END)
#
#     # 스크롤 사이 페이지 로딩시간 추가
#     time.sleep(0.7)
#
#     # 스크롤 후 높이
#     after_h = browser.execute_script("return window.scrollY")
#
#     if after_h == before_h:
#         break
#     before_h = after_h
#
# # csv 파일 생성
# f = open(r"C:\Users\chltm\PycharmProjects\naver_craw\data.csv", 'w', encoding='CP949', newline='')
# csvWriter = csv.writer(f)
#
# culpage = 1
#
# # 상품정보
# items = browser.find_elements_by_css_selector(".basicList_info_area__17Xyo")
#
# for item in items:
#     name = item.find_element_by_css_selector(".basicList_title__3P9Q7").text
#     try:
#         price = item.find_element_by_css_selector(".price_num__2WUXn").text
#     except:
#         price = "판매중단"
#
#     link = item.find_element_by_css_selector(".basicList_title__3P9Q7 > a").get_attribute('href')
#     print(name, price, link)
#
#     # 데이터 쓰기 및 입력
#     csvWriter.writerow([name, price, link])
#
# # 파일 저장 후 닫음
# f.close()