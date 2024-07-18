package com.kosta.ems.attendance;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public interface AttendanceService {
    int getNumberOfAttendance(LocalDate startDate, LocalDate endDate, String studentId);

    int getNumberOfLeave(LocalDate startDate, LocalDate endDate, String studentId);

    // [출결 조회] - 수강생 출석 조회 목록 조회
    // 2차 - 경우 1~3을 하나의 쿼리문으로 해결하기
    int getAttendanceIntegratedListAmount(String name, int courseNumber, String academyLocation);
    // List<StudentAttendanceListDTO> getAttendanceIntegratedList(String name, int courseNumber, String academyLocation, int page, int size);
    List<ArrayList> getAttendanceIntegratedList(String name, int courseNumber, String academyLocation, int page, int size);

    /*
    // 출결 입력 페이지
    // [출결] - 특정일의 수강생 출석 상태 목록 조회 (for 출결 입력/수정)
    // 경우1 _ 기수+수강생명 입력
    // 검색 결과 개수 가져오기 (for 페이지네이션)
    int getCourseNumberAndStudentNameListAmount(String attendanceDate, String academyLocation, String name, int courseNumber);
    // 검색 결과 데이터 목록 가져오기
    List<AttendanceListBySearchFilterDTO> getCourseNumberAndStudentNameList(String attendanceDate, String academyLocation, String name, int courseNumber, int page, int size);
    
    // 경우2 _ 기수 또는 수강생명 입력
    // 검색 결과 개수 가져오기 (for 페이지네이션)
    int getCourseNumberOrStudentNameListAmount(String attendanceDate, String academyLocation, String name, int courseNumber);
    // 검색 결과 데이터 목록 가져오기
    List<AttendanceListBySearchFilterDTO> getCourseNumberOrStudentNameList(String attendanceDate, String academyLocation, String name, int courseNumber, int page, int size);
    
    // 경우3 _ 기수+수강생명 미입력
    // 검색 결과 개수 가져오기 (for 페이지네이션)
    int getDateAndLocationListAmount(String attendanceDate, String academyLocation, String name, int courseNumber);
    // 검색 결과 데이터 목록 가져오기
    List<AttendanceListBySearchFilterDTO> getDateAndLocationList(String attendanceDate, String academyLocation, String name, int courseNumber, int page, int size);
     */

    // *0715 출결 입력/수정 페이지 검색 결과 데이터 목록 (경우1~3 하나로)
    int getAttendanceStatusListAmount(String attendanceDate, String academyLocation, String name, int courseNumber);
    List<AttendanceListBySearchFilterDTO> getAttendanceStatusList(String attendanceDate, String academyLocation, String name, int courseNumber, int page, int size);


    // [출결 수정]
    // 선택한 수강생의 출석 상태 수정
    void updateStudentAttendance(List<RequestStudentAttendanceDTO> dto);
    // --[출석 인정]
    // --출석 인정 항목 리스트 가져오기
    List<AttendanceAcknowledgeDTO> getAcknowledgeCategoryList(int isActive);
    // --출석 인정항목*인정일수 적용하여 출결 상태 반영 (update + insert)
    void reflectAcknowledgeAttendanceStatus(RequestAcknowledgeDTO dto);

    // [출결 입력]
    // 1. 특정일의 출결 상태가 등록되지 않은 수강생 목록 가져오기
    List<AttendanceListBySearchFilterDTO> getNoAttendanceStatusStudentList(String attendanceDate, String academyLocation);
    // 2. 목록의 학생 중 선택한 학생의 출결 상태 등록하기
    void setAttendanceStatus(String attendanceStatus, String attendanceDate, int studentCourseSeq, String managerId);
}
