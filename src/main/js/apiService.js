const PostHeaders = Object.freeze({
  "Content-Type": "application/json",
});

const get = async (url, params) => {
  let baseUrl = url;
  let urlParams = new URLSearchParams();
  if (params) {
    Object.keys(params).forEach((key) => urlParams.append(key, params[key]));
    baseUrl = `${baseUrl}?${urlParams.toString()}`;
  }
  console.log(`[GET] ${baseUrl}`);
  var fetchRes = await fetch(baseUrl);
  const jsonBody = await fetchRes.json();
  console.log(jsonBody);
  return jsonBody;
};

const post = async (url, body) => {
  console.log(`[POST] ${url}`);
  var fetchRes = await fetch(url, {
    method: "POST",
    body: JSON.stringify(body),
    headers: PostHeaders,
  });
  const jsonBody = await fetchRes.json();
  console.log(jsonBody);
  return jsonBody;
};

const deleteAction = async (url, id) => {
  let urlParams = new URLSearchParams();
  urlParams.append("id", id);
  const baseUrl = `${url}?${urlParams.toString()}`;
  console.log(`[DELETE] ${baseUrl}`);
  var fetchRes = await fetch(baseUrl, { method: "DELETE" });
  console.log(fetchRes);
};

export { get, post, deleteAction };
