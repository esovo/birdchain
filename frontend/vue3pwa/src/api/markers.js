import { markers } from ".";

// 모든 마커 조회
export const getAllMarkers = async () => {
  const res = await markers({ method: "get", url: "" });
  return res;
};

// 타입별로 마커 조회

// 마커 등록
export const registMarker = async (reqForm) => {
  const res = await markers({
    method: "post",
    url: "",
    data: reqForm,
  });
  return res;
};

// 마커 상세 조회
export const getMarkerDetail = async (marker_id) => {
  const res = await markers({
    method: "get",
    url: `/detail?id=${marker_id}`,
  });
  return res;
};
