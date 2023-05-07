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
