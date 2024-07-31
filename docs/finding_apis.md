

From https://dokumentacja-inpost.atlassian.net/wiki/spaces/PL/pages/18153493/Points+Parcel+Locker+ParcelPoint


❌

    curl -X GET https://api.inpost.pl/v1/points?city=Warszawa -H 'Content-Type: application/json'

    curl -X GET https://api.inpost.pl/v1/points?city=Kraków -H 'Content-Type: application/json'

{"timestamp":"2024-07-31T14:17:23.517+00:00","path":"/v1/points","status":403,"error":"Forbidden","message":"Access denied","requestId":"fcb7d965-8683536"}

❌

    curl --X GET https://api-shipx-pl.easypack24.net/v1/points?city=Wrocław -H 'Content-Type: application/json'

<!doctype html><html lang="en"><head><title>HTTP Status 400 – Bad Request</title><style type="text/css">body {font-family:Tahoma,Arial,sans-serif;} h1, h2, h3, b {color:white;background-color:#525D76;} h1 {font-size:22px;} h2 {font-size:16px;} h3 {font-size:14px;} p {font-size:12px;} a {color:black;} .line {height:1px;background-color:#525D76;border:none;}</style></head><body><h1>HTTP Status 400 – Bad Request</h1></body></html>

❌

    curl -X GET https://api-pl-points.easypack24.net/v1/points/?city=Wrocław -H 'Content-Type: application/json'

curl: (6) Could not resolve host: GET
<!doctype html><html lang="en"><head><title>HTTP Status 400 – Bad Request</title><style type="text/css">body {font-family:Tahoma,Arial,sans-serif;} h1, h2, h3, b {color:white;background-color:#525D76;} h1 {font-size:22px;} h2 {font-size:16px;} h3 {font-size:14px;} p {font-size:12px;} a {color:black;} .line {height:1px;background-color:#525D76;border:none;}</style></head><body><h1>HTTP Status 400 – Bad Request</h1></body></html>

✅ Wrocław -> Wroc%C5%82aw

    curl -X GET https://api-pl-points.easypack24.net/v1/points/?city=Wroc%C5%82aw -H 'Content-Type: application/json'

[./parcel_point_wrocław.json](./parcel_point_wrocław.json)


✅

    curl -X GET https://api-shipx-pl.easypack24.net/v1/points?name=WAW94A -H 'Content-Type: application/json'

[./parcel_point_WAW94A.json](./parcel_point_WAW94A.json)

❌

    curl -X GET https://api.inpost.pl/v1/points?name=KRA02APP

{"timestamp":"2024-07-31T14:13:33.830+00:00","path":"/v1/points","status":403,"error":"Forbidden","message":"Access denied","requestId":"6a6004c9-8671101"}




Trying in browser:

    https://osm.inpost.pl/nominatim/search?q=Wrocław&format=jsonv2

[{"place_id":10871620,"licence":"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright","osm_type":"relation","osm_id":2805691,"boundingbox":["51.0426686","51.2100604","16.8073393","17.1762192"],"lat":"51.1263106","lon":"16.97819633051261","display_name":"Wrocław, Lower Silesian Voivodeship, Poland","place_rank":14,"category":"boundary","type":"administrative","importance":0.51},{"place_id":10899209,"licence":"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright","osm_type":"relation","osm_id":2805690,"boundingbox":["51.0426686","51.2100604","16.8073393","17.1762192"],"lat":"51.1263106","lon":"16.97819633051261","display_name":"Wrocław, Lower Silesian Voivodeship, Poland","place_rank":16,"category":"boundary","type":"administrative","importance":0.45999999999999996},{"place_id":10931692,"licence":"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright","osm_type":"relation","osm_id":451516,"boundingbox":["51.0426686","51.2100604","16.8073393","17.1762192"],"lat":"51.1089776","lon":"17.0326689","display_name":"Wroclaw, Lower Silesian Voivodeship, Poland","place_rank":12,"category":"boundary","type":"administrative","importance":0.45},{"place_id":261489,"licence":"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright","osm_type":"node","osm_id":1368367174,"boundingbox":["51.1103376","51.1104376","17.0349661","17.0350661"],"lat":"51.1103876","lon":"17.0350161","display_name":"Wrocław, 44, Wita Stwosza, Dzielnica Czterech Wyznań, Osiedle Stare Miasto, Wroclaw, Lower Silesian Voivodeship, 50-149, Poland","place_rank":30,"category":"amenity","type":"fast_food","importance":0.11100000000000002}]

