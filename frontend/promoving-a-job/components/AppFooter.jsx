import { FaFacebookF, FaTwitter, FaLinkedinIn } from "react-icons/fa";
import { PrimaryBgColor } from "./Theme";
const AppFooter = () => {
  return (
    <div
      className="container-fluid text-center"
      style={{ backgroundColor: PrimaryBgColor, height: "10vh" }}
    >
      <div className="p-4 m-auto w-25 row">
        <FaFacebookF className="col" />
        <FaTwitter className="col" />
        <FaLinkedinIn className="col" />
      </div>
      <p className="">© Copyright 2022 - LocalJobs</p>
    </div>
  );
};

export default AppFooter;
